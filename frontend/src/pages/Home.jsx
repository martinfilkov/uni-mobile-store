import React, { useState } from 'react';
import PhoneCard from '../components/PhoneCard';
import SearchBar from '../components/SearchBar';
import FilterPanel from '../components/FilterPanel';
import SortOptions from '../components/SortOptions';
import useDebounce from '../hooks/useDebounce';

const samplePhones = [
    {
      id: 1,
      brand: 'Samsung',
      model: 'Galaxy S24',
      image: 'https://via.placeholder.com/150',
      chipset: 'Exynos 2400',
      display: '6.1" AMOLED',
      battery: '4000 mAh',
      os: 'Android 14',
      releaseDate: '2024-01-17',
      price: 899,
    },
    {
      id: 2,
      brand: 'Apple',
      model: 'iPhone 15',
      image: 'https://via.placeholder.com/150',
      chipset: 'A16 Bionic',
      display: '6.1" OLED',
      battery: '3279 mAh',
      os: 'iOS 17',
      releaseDate: '2023-09-22',
      price: 999,
    },
    {
      id: 3,
      brand: 'Google',
      model: 'Pixel 8',
      image: 'https://via.placeholder.com/150',
      chipset: 'Tensor G3',
      display: '6.2" OLED',
      battery: '4575 mAh',
      os: 'Android 14',
      releaseDate: '2023-10-12',
      price: 699,
    },
  ];
  


const brands = ['Samsung', 'Apple', 'Google'];
const osOptions = ['Android 14', 'iOS 17'];

const Home = () => {
    const [search, setSearch] = useState('');
    const debouncedSearch = useDebounce(search, 300);
  const [filters, setFilters] = useState({
    brand: '',
    os: '',
    minPrice: 0,
    maxPrice: 2000,
  });
  const [sortBy, setSortBy] = useState('');
  

  const handleFilterChange = (key, value) => {
    setFilters((prev) => ({ ...prev, [key]: value }));
  };

  const filteredPhones = samplePhones.filter((phone) =>
    `${phone.brand} ${phone.model}`.toLowerCase().includes(debouncedSearch.toLowerCase()) &&
    (filters.brand ? phone.brand === filters.brand : true) &&
    (filters.os ? phone.os === filters.os : true) &&
    phone.price >= filters.minPrice &&
    phone.price <= filters.maxPrice
  );


  const sortedPhones = [...filteredPhones].sort((a, b) => {
    if (sortBy === 'model') {
      return (a.brand.toLowerCase()+a.model.toLowerCase()).localeCompare((b.brand.toLowerCase()+b.model.toLowerCase()));
    } 
    else if(sortBy==="year") {
        return new Date(b.releaseDate) - new Date(a.releaseDate); 
    }
    else if (sortBy === 'priceLow') {
        return a.price - b.price;
      } 
      else if (sortBy === 'priceHigh') {
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
  
  return (
    <div className="container py-4">
      <h2 className="mb-4">Phone Listings</h2>

      <SearchBar searchTerm={search} onSearchChange={setSearch} />

      <FilterPanel
        filters={filters}
        onChange={handleFilterChange}
        brands={brands}
        osOptions={osOptions}
      />
      <div className="mb-4">
  <button className="btn btn-outline-danger" onClick={clearAllFilters}>
    Clear All Filters
  </button>
</div>
    <SortOptions sortBy={sortBy} onChange={setSortBy} />
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
