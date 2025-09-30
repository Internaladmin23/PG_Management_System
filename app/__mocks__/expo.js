// This mock prevents Jest from executing the complex native runtime code
// in the 'expo' package, resolving the 'ReferenceError'.

module.exports = {
  // Export a simple, empty object as the default export
  __esModule: true,
  default: {},
  // Mock common Expo exports to prevent crashes if your components use them
  useFonts: jest.fn(() => [true]), // Mock for font loading
  registerRootComponent: (Component) => Component,
};
