module.exports = {
  extends: ["@commitlint/config-conventional"],
  rules: {
    "type-enum": [
      2,
      "always",
      [
        "feat", // New feature
        "fix", // Bug fix
        "docs", // Documentation only changes
        "style", // Changes that don't affect code meaning
        "refactor", // Code change that neither fixes a bug nor adds a feature
        "perf", // Performance improvement
        "test", // Adding or correcting tests
        "chore", // Changes to build process or auxiliary tools
        "ci", // CI/CD changes
        "build", // Changes to build system or dependencies
        "revert", // Revert a previous commit
      ],
    ],
    "subject-case": [0], // Allow any case for subject
    "subject-max-length": [2, "always", 100],
    "body-max-line-length": [2, "always", 200],
  },
};
