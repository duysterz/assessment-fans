import React from 'react';
import '../App.css';


const Header = () => {
  return (
    <header className="header">
      <h1>Interior Design Fansite</h1>
      <nav>
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/about">About</a></li>
          <li><a href="/contact">Contact</a></li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
