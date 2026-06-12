import OpenAI from 'openai';
import { searchContent, saveAnswer } from './db';

const apiKey = process.env.OPENAI_API_KEY;
if (!apiKey) {
  throw new Error('OPENAI_API_KEY is required in environment variables');
}

const client = new OpenAI({ apiKey });

export async function generateAnswer(question: string) {
  const matches = searchContent(question);
  const context = matches.slice(0, 5).map(item => `Source: ${item.source}\nTitle: ${item.title}\nText: ${item.text}`).join('\n\n');
  const prompt = `You are an AI assistant helping with RGPV exam notes and previous year questions. Use the provided context and answer the user clearly. If the answer is not in the context, be honest and provide general guidance.

Context:
${context || 'No context available.'}

Question:\n${question}\n\nAnswer:`;

  const response = await client.responses.create({
    model: 'gpt-4.1-mini',
    input: prompt,
    max_output_tokens: 450,
  });

  const answer = Array.isArray(response.output) ? response.output.map(item => item.content).join('') : response.output[0]?.content || '';
  const cleaned = answer.trim();
  saveAnswer(question, cleaned);
  return cleaned;
}
