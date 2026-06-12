import 'dotenv/config';
import readline from 'readline';
import { initDatabase, getAllContent, searchContent } from './db';
import { scrapeSources } from './scraper';
import { generateAnswer } from './openaiClient';

async function runScrape() {
  initDatabase();
  console.log('Starting scrape...');
  const scraped = await scrapeSources();
  console.log(`Scraped ${scraped.length} source(s).`);
}

async function runSearch() {
  initDatabase();
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  rl.question('Enter search query: ', query => {
    const results = searchContent(query);
    if (!results.length) {
      console.log('No matching content found.');
    } else {
      console.log(`Found ${results.length} result(s):`);
      for (const item of results) {
        console.log('---');
        console.log(`ID: ${item.id}`);
        console.log(`Source: ${item.source}`);
        console.log(`Title: ${item.title}`);
        console.log(`Type: ${item.type}`);
        console.log(item.text.substring(0, 800));
      }
    }
    rl.close();
  });
}

async function runChat() {
  initDatabase();
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  console.log('Chatbot ready. Type a question and press Enter. Type `exit` to quit.');

  rl.on('line', async input => {
    const question = input.trim();
    if (!question) {
      return;
    }
    if (question.toLowerCase() === 'exit') {
      rl.close();
      return;
    }
    process.stdout.write('Thinking...\r');
    try {
      const answer = await generateAnswer(question);
      console.log(`\nAnswer:\n${answer}\n`);
    } catch (error) {
      console.error('\nError generating answer:', (error as Error).message);
    }
    rl.prompt();
  });
  rl.prompt();
}

async function main() {
  const command = process.argv[2];
  switch (command) {
    case 'scrape':
      await runScrape();
      break;
    case 'search':
      await runSearch();
      break;
    case 'chat':
      await runChat();
      break;
    default:
      console.log('Usage: npm run scrape | npm run search | npm run chat');
      break;
  }
}

main().catch(error => {
  console.error('Fatal error:', (error as Error).message);
  process.exit(1);
});
