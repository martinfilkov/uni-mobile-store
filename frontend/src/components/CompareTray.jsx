import React from 'react';
import { useCompare } from '../context/CompareContext';
import { useNavigate, useLocation } from 'react-router-dom';

const CompareTray = () => {
  const { phonesToCompare } = useCompare();
  const navigate = useNavigate();
  const location = useLocation();

  if (phonesToCompare.length === 0 || location.pathname === '/about') return null;

  return (
    <div
      style={{
        position: 'fixed',
        bottom: '20px',
        right: '20px',
        zIndex: 1000,
        backgroundColor: '#0d6efd',
        color: '#fff',
        padding: '12px 20px',
        borderRadius: '12px',
        maxWidth: '300px',
        boxShadow: '0 0 12px rgba(0,0,0,0.3)',
      }}
    >
      <div style={{ fontSize: '14px', marginBottom: '8px' }}>
        {phonesToCompare.map((phone) => (
          <div key={phone.id}>{phone.brand.name} {phone.model}</div>
        ))}
      </div>
      <div
        style={{
          backgroundColor: '#fff',
          color: '#0d6efd',
          padding: '8px 12px',
          borderRadius: '8px',
          textAlign: 'center',
          fontWeight: 'bold',
          cursor: 'pointer',
        }}
        onClick={() => navigate('/compare')}
      >
        Compare {phonesToCompare.length} Phone{phonesToCompare.length > 1 ? 's' : ''}
      </div>
    </div>
  );
};

export default CompareTray;
