import './Talent.css'
import React, { useState } from 'react'

const Talent = ({id, content, score,onUpClick, onDownClick, isUpDisabled}) => {

  return (
<div className=  "talent"> 
  
    <div class = "form-row">
    <label for= {id} class = 'form-label'>{content}</label>
    <p class = 'form-control' id = {id}>{score}</p>
    <button class = 'buttonUp' onClick={onUpClick} disabled={isUpDisabled}>Up</button>
    <button class = 'buttonDown' onClick={onDownClick} disabled={score === 0}>Undo</button>
    </div>

</div>
  )
}

export default Talent