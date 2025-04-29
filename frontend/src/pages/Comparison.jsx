import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useCompare } from '../context/CompareContext';

const specFields = [
  { label: 'Brand', key: (phone) => phone.brand?.name },
  { label: 'Model', key: (phone) => phone.model },
  { label: 'Build', key: (phone) => phone.build },
  { label: 'Dimensions', key: (phone) => phone.dimensions },
  { label: 'Weight', key: (phone) => `${phone.weight}g` },
  { label: 'Display Type', key: (phone) => phone.displayType },
  { label: 'Resolution', key: (phone) => phone.resolution },
  { label: 'Screen Size', key: (phone) => `${phone.screenSize}"` },
  { label: 'Chipset/GPU', key: (phone) => phone.gpu },
  { label: 'Main Camera', key: (phone) => phone.mainCamera },
  { label: 'Video', key: (phone) => phone.processor },
  { label: 'Camera Features', key: (phone) => phone.mainCameraFeature },
  { label: 'Selfie Camera', key: (phone) => phone.selfieCamera },
  { label: 'Battery Type', key: (phone) => phone.batteryType },
  { label: 'Charging', key: (phone) => phone.charging },
  { label: 'SIM', key: (phone) => phone.sim },
  { label: 'OS', key: (phone) => phone.operatingSystem },
  { label: 'Sensors', key: (phone) => phone.sensors },
  { label: 'Color', key: (phone) => phone.color },
  { label: 'RAM', key: (phone) => `${phone.ram} GB` },
  { label: 'Storage', key: (phone) => `${phone.storage} GB` },
  { label: 'Price', key: (phone) => `$${phone.price}` },
  { label: 'Release Date', key: (phone) => phone.releaseDate },
];

const Comparison = () => {
  const { phonesToCompare, removeFromCompare } = useCompare();
  const navigate = useNavigate();
  const [redirecting, setRedirecting] = useState(false);

  useEffect(() => {
    if (phonesToCompare.length === 0) {
      setRedirecting(true);
      const timeout = setTimeout(() => navigate('/'), 2000);
      return () => clearTimeout(timeout);
    }
  }, [phonesToCompare, navigate]);

  if (redirecting) {
    return (
      <div className="container text-center py-5">
        <h4>No phones to compare.</h4>
        <p className="text-muted">Redirecting you to the homepage...</p>
      </div>
    );
  }

  return (
    <div className="container py-4">
      <h2 className="mb-4">Compare Phones</h2>

      <div className="row text-center">
        <div className="col-2 fw-bold text-start">Specs</div>
        {phonesToCompare.map((phone) => (
          <div className="col" key={phone.id}>
            <img src={`/image/${phone.image}`} alt={phone.model} className="img-fluid mb-2" style={{ maxHeight: '150px' }} />
            <h5>{phone.brand?.name} {phone.model}</h5>
            <button className="btn btn-sm btn-outline-danger mt-2" onClick={() => removeFromCompare(phone.id)}>
              Remove
            </button>
          </div>
        ))}
      </div>

      {specFields.map(({ label, key }) => (
        <div className="row text-center py-2 border-top" key={label}>
          <div className="col-2 text-start fw-semibold">{label}</div>
          {phonesToCompare.map((phone) => (
            <div className="col" key={phone.id}>
              {key(phone) || '—'}
            </div>
          ))}
        </div>
      ))}
    </div>
  );
};

export default Comparison;
