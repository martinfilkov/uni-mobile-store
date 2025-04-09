import React from 'react';
import Slider from 'rc-slider';
import 'rc-slider/assets/index.css';



const FilterPanel = ({ filters, onChange, brands = [], osOptions = [] }) => {
    const handleRangeChange = ([min, max]) => {
      onChange('minPrice', min);
      onChange('maxPrice', max);
    };

  return (
    <div className="mb-4 row g-3">
      <div className="col-md-3">
        <label className="form-label">Brand</label>
        <select
          className="form-select"
          value={filters.brand || ''}
          onChange={(e) => onChange('brand', e.target.value)}
        >
          <option value="">All</option>
          {brands.map((brand) => (
            <option key={brand} value={brand}>{brand}</option>
          ))}
        </select>
      </div>

      <div className="col-md-3">
        <label className="form-label">OS</label>
        <select
          className="form-select"
          value={filters.os || ''}
          onChange={(e) => onChange('os', e.target.value)}
        >
          <option value="">All</option>
          {osOptions.map((os) => (
            <option key={os} value={os}>{os}</option>
          ))}
        </select>
      </div>

      <div className="col-md-3">
        <label className="form-label">Price Range: ${filters.minPrice} – ${filters.maxPrice}</label>
  <Slider
  range
  min={0}
  max={2000}
  step={50}
  allowCross={false}
  value={[filters.minPrice, filters.maxPrice]}
  onChange={([min, max]) => {
    onChange('minPrice', min);
    onChange('maxPrice', max);
  }}
/>
</div>
      </div>
  );
};

export default FilterPanel;
