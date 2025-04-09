import React from 'react';
import { useParams } from 'react-router-dom';

const PhoneDetails = () => {
  const { id } = useParams();

  const phone = {
    id,
    model: 'Galaxy S24',
    brand: 'Samsung',
    image: 'https://via.placeholder.com/300',
    chipset: 'Exynos 2400',
    display: '6.1" AMOLED',
    battery: '4000 mAh',
    camera: '50MP + 12MP + 10MP',
    os: 'Android 14',
  };

  return (
    <div className="container py-4">
      <div className="row">
        <div className="col-md-5">
          <img src={phone.image} alt={phone.model} className="img-fluid" />
        </div>
        <div className="col-md-7">
          <h2>{phone.brand} {phone.model}</h2>
          <ul className="list-group">
            <li className="list-group-item"><strong>Chipset:</strong> {phone.chipset}</li>
            <li className="list-group-item"><strong>Display:</strong> {phone.display}</li>
            <li className="list-group-item"><strong>Battery:</strong> {phone.battery}</li>
            <li className="list-group-item"><strong>Camera:</strong> {phone.camera}</li>
            <li className="list-group-item"><strong>OS:</strong> {phone.os}</li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default PhoneDetails;
