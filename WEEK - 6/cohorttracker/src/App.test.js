import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Cognizant Cohort Tracker title', () => {
  render(<App />);
  const titleElement = screen.getByText(/Cognizant Cohort Tracker/i);
  expect(titleElement).toBeInTheDocument();
});
