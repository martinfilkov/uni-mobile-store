import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useCompare } from '../context/CompareContext';

const PhoneDetails = () => {
  const { id } = useParams();
  const [phone, setPhone] = useState(null);
  const [error, setError] = useState(null);

  const { phonesToCompare, addToCompare, removeFromCompare } = useCompare();

  useEffect(() => {
    fetch(`http://localhost:8080/mobile/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error('Failed to fetch phone details');
        return res.json();
      })
      .then((data) => setPhone(data.mobile))
      .catch((err) => {
        console.error('Error fetching phone details:', err);
        setError('Could not load phone details');
      });
  }, [id]);

  if (error) return <div className="container py-4"><h4>{error}</h4></div>;
  if (!phone) return <div className="container py-4"><h4>Loading...</h4></div>;

  const isInCompare = phonesToCompare.some(p => p.id === phone.id);

  return (
    <div className="container py-4">
      <div className="row mb-4">
        <div className="col-md-5 text-center">
        <img src={`/image/${phone.image}`} alt={phone.model} className="img-fluid rounded" />
        </div>
        <div className="col-md-7">
          <h2>{phone.brand.name} {phone.model}</h2>
          <p className="text-muted">Released: {new Date(phone.releaseDate).toLocaleDateString()}</p>
          <h4 className="text-success mb-3">${phone.price}</h4>

          <button
            className={`btn btn-${isInCompare ? 'danger' : 'outline-secondary'} mb-4`}
            onClick={() =>
              isInCompare ? removeFromCompare(phone.id) : addToCompare(phone)
            }
          >
            {isInCompare ? 'Remove from Compare' : 'Add to Compare'}
          </button>

          <ul className="list-group">
            <li className="list-group-item"><strong>Brand Country:</strong> {phone.brand.country}</li>
            <li className="list-group-item"><strong>OS:</strong> {phone.operatingSystem}</li>
            <li className="list-group-item"><strong>Chipset / GPU:</strong> {phone.gpu}</li>
            <li className="list-group-item"><strong>Display:</strong> {phone.displayType}, {phone.screenSize}"</li>
            <li className="list-group-item"><strong>Resolution:</strong> {phone.resolution}</li>
            <li className="list-group-item"><strong>RAM / Storage:</strong> {phone.ram}GB / {phone.storage}GB</li>
            <li className="list-group-item"><strong>Battery:</strong> {phone.batteryType} – {phone.charging}</li>
            <li className="list-group-item"><strong>Main Camera:</strong> {phone.mainCamera}</li>
            <li className="list-group-item"><strong>Video:</strong> {phone.processor}</li>
            <li className="list-group-item"><strong>Camera Features:</strong> {phone.mainCameraFeature}</li>
            <li className="list-group-item"><strong>Selfie Camera:</strong> {phone.selfieCamera}</li>
            <li className="list-group-item"><strong>Dimensions:</strong> {phone.dimensions}</li>
            <li className="list-group-item"><strong>Weight:</strong> {phone.weight}g</li>
            <li className="list-group-item"><strong>Build:</strong> {phone.build}</li>
            <li className="list-group-item"><strong>Color:</strong> {phone.color}</li>
            <li className="list-group-item"><strong>Sensors:</strong> {phone.sensors}</li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default PhoneDetails;
