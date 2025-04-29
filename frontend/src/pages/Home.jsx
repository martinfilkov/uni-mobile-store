import React, { useState, useEffect } from 'react';
import PhoneCard from '../components/PhoneCard';
import SearchBar from '../components/SearchBar';
import FilterPanel from '../components/FilterPanel';
import SortOptions from '../components/SortOptions';
import useDebounce from '../hooks/useDebounce';

const Home = () => {
  const [phones, setPhones] = useState([]);
  const [loading, setLoading] = useState(true);
  const [search, setSearch] = useState('');
  const debouncedSearch = useDebounce(search, 300);
  const [filters, setFilters] = useState({
    brand: '',
    os: '',
    minPrice: 0,
    maxPrice: 2000,
  });
  const [sortBy, setSortBy] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/mobile')
      .then((res) => res.json())
      .then((data) => {
        setPhones(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error('Error fetching phones:', err);
        setLoading(false);
      });
  }, []);

  const brands = [...new Set(phones.map((p) => p.brand.name))];
  const osOptions = ['Android', 'iOS'];

  const handleFilterChange = (key, value) => {
    setFilters((prev) => ({ ...prev, [key]: value }));
  };

  const filteredPhones = phones.filter((phone) =>
    `${phone.brand.name} ${phone.model}`.toLowerCase().includes(debouncedSearch.toLowerCase()) &&
    (filters.brand ? phone.brand.name === filters.brand : true) &&
    (filters.os ? phone.operatingSystem === filters.os : true) &&
    phone.price >= filters.minPrice &&
    phone.price <= filters.maxPrice
  );

  const sortedPhones = [...filteredPhones].sort((a, b) => {
    if (sortBy === 'model') {
      return (a.brand.name.toLowerCase() + a.model.toLowerCase())
        .localeCompare(b.brand.name.toLowerCase() + b.model.toLowerCase());
    } else if (sortBy === 'year') {
      return new Date(b.releaseDate) - new Date(a.releaseDate);
    } else if (sortBy === 'priceLow') {
      return a.price - b.price;
    } else if (sortBy === 'priceHigh') {
      return b.price - a.price;
    }
    return 0;
  });

  const clearAllFilters = () => {
    setFilters({
      brand: '',
      os: '',
      minPrice: 0,
      maxPrice: 2000,
    });
    setSearch('');
    setSortBy('');
  };

  if (loading) {
    return (
      <div className="container text-center py-5">
        <h4>Loading phones...</h4>
      </div>
    );
  }

  return (
    <div className="container py-4">
    <h2 className="section-title">Browse Our Phones</h2>
  
    <div className="filters-grid mb-4">
      <div className="filters-top">
        <SearchBar searchTerm={search} onSearchChange={setSearch} />
      </div>
  
      <div className="filters-options">
        <FilterPanel
          filters={filters}
          onChange={handleFilterChange}
          brands={brands}
          osOptions={osOptions}
        />
      </div>
  
      {/* <div className="filters-actions">
        <button className="btn btn-outline-danger w-100" onClick={clearAllFilters}>
          Clear All Filters
        </button>
      </div> */}
  
      <div className="filters-sort">
        <SortOptions sortBy={sortBy} onChange={setSortBy} />
      </div>
    </div>
  
    <div className="row">
      {filteredPhones.length > 0 ? (
        sortedPhones.map((phone) => (
          <div className="col-12 col-sm-6 col-md-4 col-lg-3" key={phone.id}>
            <PhoneCard phone={phone} />
          </div>
        ))
      ) : (
        <p className="text-center mt-4">No phones match your search or filters.</p>
      )}
    </div>
  </div>
  
  );
};

export default Home;
