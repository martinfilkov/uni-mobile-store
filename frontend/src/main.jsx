import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { CompareProvider } from './context/CompareContext';
ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <CompareProvider>
      <App />
    </CompareProvider>
  </BrowserRouter>
);
