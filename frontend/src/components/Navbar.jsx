import React from 'react';
import { Link, NavLink } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar">
      <div className="container">
        <Link className="navbar-brand d-flex align-items-center" to="/">
          <img 
            src="/image/logo.png" 
            alt="Mobile Zone Logo" 
            style={{ height: '30px', marginRight: '10px' }} 
          />
          Mobile Zone
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <NavLink to="/" className="nav-link" end>Home</NavLink>
              </li>
            <li className="nav-item">
              <NavLink to="/about" className="nav-link" end>About</NavLink>
              </li>
          
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
