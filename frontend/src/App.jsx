import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import PhoneDetails from './pages/PhoneDetails';
import Comparison from './pages/Comparison';
import CompareTray from './components/CompareTray';
import About  from './pages/About';
function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/phone/:id" element={<PhoneDetails />} />
        <Route path="/compare" element={<Comparison />} />
        <Route path="/about" element={<About />} />
      </Routes>
      <CompareTray />
    </>
  );
}

export default App;
