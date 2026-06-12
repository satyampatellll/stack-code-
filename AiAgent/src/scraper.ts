import axios from 'axios';
import cheerio from 'cheerio';
import { saveContent } from './db';

export interface ScrapedItem {
  source: string;
  title: string;
  type: 'note' | 'question';
  text: string;
}

const sources = [
  {
    url: 'https://example.com/rgpv-notes',
    source: 'RGPV Notes',
    type: 'note' as const,
    titleSelector: 'h1, h2, h3',
    contentSelector: '.content, .article-body',
  },
  {
    url: 'https://example.com/rgpv-previous-year-questions',
    source: 'RGPV PYQs',
    type: 'question' as const,
    titleSelector: 'h1, h2, h3',
    contentSelector: '.content, .question-list',
  },
];

async function fetchHtml(url: string) {
  const response = await axios.get(url, { timeout: 15000 });
  return response.data as string;
}

function extractText($: cheerio.CheerioAPI, selector: string) {
  return $(selector)
    .map((_, el) => $(el).text().trim())
    .get()
    .filter(Boolean)
    .join('\n\n');
}

export async function scrapeSources() {
  const results: ScrapedItem[] = [];
  for (const source of sources) {
    try {
      const html = await fetchHtml(source.url);
      const $ = cheerio.load(html);
      const title = extractText($, source.titleSelector) || source.source;
      const text = extractText($, source.contentSelector) || html.slice(0, 2000);
      results.push({ source: source.source, title, type: source.type, text });
      saveContent(source.source, title, source.type, text);
    } catch (error) {
      console.error(`Failed to scrape ${source.url}:`, (error as Error).message);
    }
  }
  return results;
}
