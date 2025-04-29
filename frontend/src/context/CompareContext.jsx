import React, { createContext, useContext, useState } from 'react';
import { useEffect } from 'react';

const CompareContext = createContext();

export const useCompare = () => useContext(CompareContext);

export const CompareProvider = ({ children }) => {
    const [phonesToCompare, setPhonesToCompare] = useState(() => {
        const saved = localStorage.getItem('comparePhones');
        return saved ? JSON.parse(saved) : [];
      });
      
      useEffect(() => {
        localStorage.setItem('comparePhones', JSON.stringify(phonesToCompare));
      }, [phonesToCompare]);

  const addToCompare = (phone) => {
    setPhonesToCompare((prev) => {
      if (prev.find(p => p.id === phone.id)) return prev;
      return prev.length < 3 ? [...prev, phone] : prev;
    });
  };

  const removeFromCompare = (id) => {
    setPhonesToCompare((prev) => prev.filter(p => p.id !== id));
    
  };

  return (
    <CompareContext.Provider value={{ phonesToCompare, addToCompare, removeFromCompare }}>
      {children}
    </CompareContext.Provider>
  );
};
