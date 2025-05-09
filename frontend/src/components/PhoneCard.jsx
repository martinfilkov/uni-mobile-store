import React from 'react';
import { Link } from 'react-router-dom';
const PhoneCard = ({ phone }) => {
  const { id, model, brand, image, chipset, display, battery } = phone;
  return (
    <div className="card mb-4 shadow-sm h-100">
      <img
        src={`/image/${image}`} 
        className="card-img-top"
        alt={model}
        style={{ height: '220px', objectFit: 'contain' }}
      />
      <div className="card-body d-flex flex-column">
      <h5>{brand.name} {model}</h5>
        <p className="card-text mb-4">
          <strong>Chipset:</strong> {phone.gpu}<br />
          <strong>Display:</strong> {phone.displayType}<br />
          <strong>Screen size:</strong> {phone.screenSize}<br />
          <strong>Price:</strong> ${phone.price}
        </p>
        <Link to={`/phone/${id}`} className="btn btn-primary mt-auto">
          View Details
        </Link>
      </div>
    </div>
  );
};

export default PhoneCard;
