import React from 'react';

const phonesToCompare = [
  {
    id: 1,
    model: 'Galaxy S24',
    brand: 'Samsung',
    image: 'https://via.placeholder.com/150',
    chipset: 'Exynos 2400',
    display: '6.1" AMOLED',
    battery: '4000 mAh',
    camera: '50MP Triple',
    os: 'Android 14',
  },
  {
    id: 2,
    model: 'iPhone 15',
    brand: 'Apple',
    image: 'https://via.placeholder.com/150',
    chipset: 'A16 Bionic',
    display: '6.1" OLED',
    battery: '3279 mAh',
    camera: '48MP Dual',
    os: 'iOS 17',
  },
];

const specFields = ['Chipset', 'Display', 'Battery', 'Camera', 'OS'];

const Comparison = () => {
  return (
    <div className="container py-4">
      <h2 className="mb-4">Compare Phones</h2>
      <div className="row text-center">
        <div className="col-2 text-start fw-bold">Specs</div>
        {phonesToCompare.map((phone) => (
          <div className="col" key={phone.id}>
            <img src={phone.image} alt={phone.model} className="img-fluid mb-2" />
            <h5>{phone.brand} {phone.model}</h5>
          </div>
        ))}
      </div>
      {specFields.map((field) => (
        <div className="row text-center py-2 border-top" key={field}>
          <div className="col-2 text-start fw-semibold">{field}</div>
          {phonesToCompare.map((phone) => (
            <div className="col" key={phone.id}>{phone[field.toLowerCase()]}</div>
          ))}
        </div>
      ))}
    </div>
  );
};

export default Comparison;
