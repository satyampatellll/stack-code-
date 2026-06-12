# RGPV AI Agent

A TypeScript AI agent for collecting RGPV notes and previous year questions, storing them locally in SQLite, and answering questions with an LLM-powered chatbot.

## Features

- Web scraping for RGPV notes and previous year questions
- SQLite storage for notes and Q&A content
- Retrieval-augmented chatbot using OpenAI
- Command-line interface for scraping, searching, and interactive chat

## Setup

1. Copy `.env.example` to `.env`
2. Set `OPENAI_API_KEY`
3. Install dependencies:

```bash
npm install
```

4. Run the project in development mode:

```bash
npm run dev
```

## Commands

- `npm run scrape` — fetch and store notes/questions from configured sources
- `npm run chat` — ask the chatbot single questions interactively
- `npm run search` — search local notes and questions
- `npm run build` — compile TypeScript
- `npm start` — run compiled app

## Notes

Update `src/scraper.ts` with actual RGPV site URLs and selectors for notes or previous year question sources.
