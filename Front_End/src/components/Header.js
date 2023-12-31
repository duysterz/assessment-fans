import React from 'react';
import { Link } from 'react-router-dom';  
import '../App.css';

const Header = () => {
  return (
    <header className="header">
      <h1> Divine Flip Designs </h1>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li> 
          <li><Link to="/about">About</Link></li> 
          <li><Link to="/upload">Upload</Link></li>
          <li><Link to="/contact">Contact</Link></li>
          
        </ul>
      </nav>
    </header>
  );
};

export default Header;
