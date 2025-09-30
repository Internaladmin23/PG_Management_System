module.exports = {
  // Backend files
  "backend/**/*.java": ["cd backend && ./gradlew checkstyleMain checkstyleTest --no-daemon"],

  // app TypeScript/JavaScript files
  "app/**/*.{ts,tsx,js,jsx}": ["cd app && npm run lint:fix", "cd app && npm run format"],

  // app test files
  "app/**/*.test.{ts,tsx}": ["cd app && npm test -- --findRelatedTests --watchAll=false"],

  // JSON files
  "**/*.json": ["prettier --write"],

  // YAML files
  "**/*.{yml,yaml}": ["prettier --write"],

  // Markdown files
  "**/*.md": ["prettier --write"],
};
