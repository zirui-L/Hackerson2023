import React from 'react';
import "./Home.css";
import TalentBox from './Components/TalentBox.js'
const Home = () => {
    return (
        <div id="header">
          <div className="introduction">
            <h1>Restart your <span>LIFE!</span><br /></h1>
            
          </div>
          
          <TalentBox id = 'box'/>
        </div>
      );
}

export default Home
