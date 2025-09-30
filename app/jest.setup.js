// Mock Expo modules and Winter runtime
jest.mock('expo', () => ({
  ...jest.requireActual('expo'),
  __ExpoImportMetaRegistry: {},
}));

// Mock Expo Winter runtime specifically
global.__ExpoImportMetaRegistry = {};

// Set development mode
global.__DEV__ = true;
