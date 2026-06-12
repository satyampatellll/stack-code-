import Database from 'better-sqlite3';

const dbPath = process.env.DB_PATH || 'rgpv-agent.db';
const db = new Database(dbPath);

export interface ContentItem {
  id: number;
  source: string;
  title: string;
  type: 'note' | 'question' | 'answer';
  text: string;
  createdAt: string;
  updatedAt: string;
}

export function initDatabase() {
  db.prepare(`
    CREATE TABLE IF NOT EXISTS content (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      source TEXT,
      title TEXT,
      type TEXT,
      text TEXT,
      createdAt TEXT,
      updatedAt TEXT
    )
  `).run();
  db.prepare(`
    CREATE INDEX IF NOT EXISTS idx_content_type ON content(type);
  `).run();
  db.prepare(`
    CREATE INDEX IF NOT EXISTS idx_content_source ON content(source);
  `).run();
}

export function saveContent(source: string, title: string, type: ContentItem['type'], text: string) {
  const now = new Date().toISOString();
  db.prepare(`
    INSERT INTO content (source, title, type, text, createdAt, updatedAt)
    VALUES (?, ?, ?, ?, ?, ?)
  `).run(source, title, type, text, now, now);
}

export function searchContent(query: string, type?: ContentItem['type']) {
  const wildcard = `%${query}%`;
  const stmt = type
    ? db.prepare(`SELECT * FROM content WHERE type = ? AND (title LIKE ? OR text LIKE ?) ORDER BY createdAt DESC`)
    : db.prepare(`SELECT * FROM content WHERE title LIKE ? OR text LIKE ? ORDER BY createdAt DESC`);
  return type ? stmt.all(type, wildcard, wildcard) : stmt.all(wildcard, wildcard);
}

export function getAllContent(type?: ContentItem['type']) {
  const stmt = type
    ? db.prepare(`SELECT * FROM content WHERE type = ? ORDER BY createdAt DESC`)
    : db.prepare(`SELECT * FROM content ORDER BY createdAt DESC`);
  return stmt.all(type);  
}

export function saveAnswer(question: string, answer: string) {
  saveContent('chatbot', question, 'answer', answer);
}
