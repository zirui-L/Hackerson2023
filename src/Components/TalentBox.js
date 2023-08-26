import './TalentBox.css'
import React, { useState } from 'react'
import Talent from './Talent.js'

const TalentBox = () => {
  // inital talents
  const initialTalents = [
    {
      id : 'iq',
      content : 'Intellgence',
      score: 1, 
    },
    {
      id : 'wealth',
      content : 'Family Welfare',
      score: 1, 
    },
    {
      id : 'physical',
      content : 'Physical',
      score: 1, 
    },
    {
      id : 'eq',
      content : 'Emotional Quotient',
      score: 1, 
    },
    {
      id : 'memory',
      content : 'Memory Ability',
      score: 1, 
    },
    // Add more projects as needed
  ];
  // using set state so we can change and keep track of the data in run time
  const [talents, setTalents] = useState(initialTalents);
  const [totalScore, setTotal] = useState(6);
  const limit = 20;

  const isUpDisabled = totalScore >= limit;
  // when up is click find the talent using its id and add for total score
  const handleUpClick = (id) => {
    setTotal(prevTotal => prevTotal + 1);
    setTalents(prevTalents => 
      prevTalents.map(talent => 
          talent.id === id ? { ...talent, score: talent.score + 1 } : talent
      )
    );
  }
  // similar
  const handleDownClick = (id) => {
    setTotal(prevTotal => prevTotal - 1);
    setTalents(prevTalents => 
      prevTalents.map(talent => 
          talent.id === id ? { ...talent, score: talent.score - 1 } : talent
      )
    );
  }
  
  
  return (
    <div className=  "talentBox">
    <h1>If you can born agian what skills would you like?</h1>
    <p>The initial limit is {limit}!</p>
    <p>current: {totalScore}</p>
    <div className='box'>
    {talents.map(talent => (
                <Talent 
                    key={talent.id} 
                    id = {talent.id}
                    content={talent.content}
                    score ={talent.score} 
                    isUpDisabled={isUpDisabled} 
                    onUpClick={() => handleUpClick(talent.id)}
                    onDownClick={() => handleDownClick(talent.id)}
                />
            ))}

    </div>
    </div>
  )
}

export default TalentBox