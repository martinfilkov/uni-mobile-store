import React from 'react';

const SortOptions = ({ sortBy, onChange }) => {
  return (
    <div className="mb-4">
      <label className="form-label me-2">Sort by:</label>
      <select className="form-select w-auto d-inline-block" value={sortBy} onChange={(e) => onChange(e.target.value)}>
        <option value="">None</option>
        <option value="model">Model (A–Z)</option>
        <option value="year">Release year</option>
        <option value="priceLow">Price (Low to High)</option>
        <option value="priceHigh">Price (High to Low)</option>
      </select>
    </div>
  );
};

export default SortOptions;
