import React from "react";
import "./style.css";
import Home from "./Home"
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";


function App() {
  return (
    
      <Routes>
        <Route path="/" element={<Home/>}/>
      </Routes>
    
  );
}

export default App;
