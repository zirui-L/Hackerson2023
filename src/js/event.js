const event = [
  {
    year: 1, // 第一年
    context: "This year, when you were born, you choked on the amniotic fluid and almost didn't recover.", //事件内容
    img: require('@/assets/baby.png'), // 图片信息
    status: 0 // 0为普通事件，1为选项事件，2为结束
  },
  {
    year: 2,
    context: "Now, you learned how to eat. Your parents lefted a cup of water and a cupcake when they leave the house. You decided to have a taste of...",
    status: 1,
    /**
     * @label 选项名称
     * @power 获得能力
     * @index 进行事件跳跃
     * **/
    list: [{ label: 'Water', power: { IQ: 6 }, index: 2 }, { label: 'CupCake', power: { Health: -2 }, index: 1 }]
  },
  {
    year: 2,
    context: "The cupcake was too hard for you to swallow. You chocked to death",
    status: 2
  },
  {
    year: 3,
    context: 'Then, you began to walk alone. You tried to climp up the stair and fell',
    img: require('@/assets/stairsFell.png'),
    status: 0
  },
  {
    year: 6,
    context: 'This year, your parent wants to send you to pre-school tutoring, and you decided to...',
    status: 1,
    /**
     * @label 选项名称
     * @power 获得能力
     * @index 进行事件跳跃
     * **/
    list: [{ label: 'Attend the tutoring!', power: { IQ: 16 } }, { label: 'No! I hate studying!', power: { Happyness: 6 } }],
    random: [
      {
        year: 6,
        context: 'You did poorly in every exam and the tutor kicked you out',
        status: 1,
        list: [{ label: 'I hate tutoring so much!', power: { IQ: -10, Charm: -6, Happiness: -6 } }, { label: 'I still like                                 tutoring!', power: { IQ: 1 } }]
      },
      {
        year: 6,
        context: 'You did excellent in every exam and the tutor award you the best student trophy',
        status: 1,
        list: [{ label: 'I really love tutoring!', power: { IQ: 18, Charm: 12, Happiness: 12 } }, { label: 'I still hate                                   tutoring!', power: { IQ: 0.1, Happiness: -0.1 } }]
      },
      {
        year: 6,
        context: 'You went into an accident on your way to tutoring and you got into the ICU',
        power: { Health: -40, Wealth: -20, Charm: -20, IQ: -15, Happiness: -40 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You went into an accident on your way to tutoring and you passed away',
        power: { Health: -100, Happiness: -100 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You caught a cold',
        power: { Health: -9, Happiness: -9 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You caught a COVID',
        power: { Health: -15, Wealth: -8, Happiness: -10 },
        status: 0
      },
      {
        year: 6,
        context: 'OH NO! You broke your right leg while going down the stairs',
        power: { Health: -15, Wealth: -6, Happiness: -10 },
        status: 0
      },
    ]
  },
  {
    year: 6,
    context: "It is time to choose the hobby that you like. Which one is your favourite",
    status: 1,
    list: [{ label: 'I love Sport!', power: { Health: 17 } }, { label: 'No! Art is my true love!', power: { Charm: 8 } }, { label: 'No other stuff than Study would I pick!', power: { IQ: 13 } }]
  },
  {
    year: 7,
    context: 'Your first summer vacation is coming...',
    img: require('@/assets/SV.jpeg'),
    status: 0
  },
  {
    year: 7,
    context: 'Your mom took you to a thrilling baseball game, where you cheered for our team, shared exciting moments, and created lasting memories together.',
    status: 1,
    list: [{ label: 'I want to play baseball', power: { Health: 12 }, index: 1 }, { label: 'It is too hard', power: { Health: 0 }, index: 1 }]
  },
  {
    year: 8,
    context: "Your Mom brought you to the piano concert, The captivating sounds draw your attention…",
    status: 1,
    list: [{ label: 'Mom I want that!', power: { charm: 8 }, index: 1 }, { label: 'Piano is so load and noisy!!', power: { Charm: 0 }, index: 1 }],
    random: [
      {
        year: 6,
        context: 'You went into an accident on your way to piano concert and you got into the ICU',
        power: { Health: -60, Wealth: -30, Charm: -20, IQ: -29, Happiness: -40 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You went into an accident on your way to piano concert, and you passed away',
        power: { Health: -100, Happiness: -100 },
        status: 2
      },
      {
        year: 6,
        context: 'Unfortunately, You caught a cold',
        power: { Health: -7, Happiness: -5 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You caught a COVID',
        power: { Health: -25, Wealth: -5, Happiness: -14 },
        status: 0
      },
      {
        year: 6,
        context: 'OH NO! You broke your right leg while going down the stairs',
        power: { Health: -15, Wealth: -3, Happiness: -6 },
        status: 0
      },
    ]
  },
  {
    year: 8,
    context: "Your parents bought you a new Jigsaw Puzzle, you often play with it. Yet one day you find some of the pieces missing",
    status: 1,
    list: [{ label: ":( I'll let my mom buy me more of them", power: { IQ: 6 }, index: 1 }, { label: "This easily ruins my product, I am not going to play it anymore", power: { IQ: 0 }, index: 1 }]
  },
  {
    year: 8,
    context: "On a lovely afternoon, you saw your grandma doing Sudoku, you asked your grandma to teach you.",
    status: 1,
    list: [{ label: 'O I love It! One more play!', power: { IQ: 6 }, index: 1 }, { label: 'It is so boring..', power: { IQ: 0 }, index: 1 }],
  },
  {
    year: 10,
    context: 'Hey! You are a high school student now!',
    img: require('@/assets/HS.jpeg'),
    status: 0
  },
  {
    year: 10,
    context: "Tom askes you to go out, but the exam is coming in 3 days...What would you do?",
    status: 1,
    list: [{ label: 'Play!', power: { IQ: -7 }, index: 1 }, { label: 'Study!', power: { IQ: 12 }, index: 1 }]
  },
  {
    year: 11,
    context: "Poor boy/girl, you were bullied by some senior students. Would you like to fight back?",
    status: 1,
    list: [{ label: 'Punch in their faces!', power: { Charm: 7 }, index: 1 }, { label: 'Be punched...', power: { Health: -12, Happiness: -22 }, index: 1 }]
  },
  {
    year: 11,
    context: "You just got your final exam result, do you want to share with your parents",
    status: 1,
    list: [{ label: 'I have no fear! ', power: { IQ: 0 }, index: 1 }, { label: 'Nope thank you!', power: { IQ: 0 }, index: 1 }]
  },
  {
    year: 12,
    context: "You have finished HSC, What is your next step?",
    status: 1,
    list: [{ label: 'University', power: { Charm: 0 }, index: 1 }, { label: 'TAFE', power: { Health: 0 }, index: 2 }]
  },
  {
    year: 13,
    context: "Here comes our uni student!",
    img: require('@/assets/uni.jpg'),
    status: 0,
  },
  {
    year: 13,
    context: "You are at the Open Week, there are lots of clubs and societies, would you like to join one or more of them?",
    status: 1,
    list: [{ label: 'Definitely!', power: { Charm: 5, IQ: 10 }, index: 3 }, { label: 'No', power: { Health: 0 }, index: 3 }],
  },
  {
    year: 13,
    context: "Here comes our TAFE student!",
    img: require('@/assets/tafe.jpg'),
    status: 0
  },
  {
    year: 13,
    context: "You are at the Open Week, there are lots of clubs and societies, would you like to join one or more of them?",
    status: 1,
    list: [{ label: 'Definitely!', power: { Charm: 5, IQ: 10 }, index: 1 }, { label: 'No', power: { Health: 0 }, index: 1 }]
  },
  {
    year: 14,
    context: "You have a crush on a boy/girl, would you like to express your further interest?",
    status: 1,
    list: [{ label: 'Definitely!', power: { Charm: 10, Happiness: 15 }, index: 1 }, { label: "No, don't really like him/her           anymore :( ", power: { Health: 0 }, index: 2 }]
  },
  {
    year: 14,
    context: "Luckly, he/she is also into you, you guys are together NOW!!!",
    status: 0
  },
  {
    year: 14,
    context: "You choose to be single",
    status: 0
  },
  {
    year: 16,
    context: "You are offered with an opportunity to travel oversea for an internship, would you like to go?",
    status: 1,
    list: [{ label: 'Definitely!', power: { IQ: 10, Wealth: 5 }, index: 1 }, { label: 'No', power: { Health: 0 }, index: 1 }]
  },
  {
    year: 22,
    context: "Its been a tough period, but you've finally made it!! Congratulations for fininshing your uni study! Woohoo~",
    img: require('@/assets/graduate.jpeg'),
    status: 0

  },
  {
    year: 22,
    context: "You've been looking forward to the road trip for a long time, but at the same time, the company you've been longing for sent you their offer",
    status: 1,
    list: [{ label: 'I really need a break! There are planty of oppotunities for me to take after I came back', power: { Happyness: 10 } }, { label: 'No, we still love each other', power: { Wealth: 1 } }],
    random: [
      {
        year: 6,
        context: 'You went into an accident on your roadtrip and you got into the ICU',
        power: { Health: -50, Wealth: -40, Charm: -30, IQ: -20, Happiness: -40 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You went into an accident on your road trip and you passed away',
        power: { Health: -100, Happiness: -100 },
        status: 2
      },
      {
        year: 6,
        context: 'Unfortunately, You caught a cold',
        power: { Health: -3, Happiness: -1 },
        status: 0
      },
      {
        year: 6,
        context: 'Unfortunately, You caught a COVID',
        power: { Health: -25, Wealth: -5, Happiness: -20 },
        status: 0
      },
      {
        year: 6,
        context: 'OH NO! You broke your right leg while going down the stairs',
        power: { Health: -15, Wealth: -5, Happiness: -10 },
        status: 0
      },
    ]
  },
  {
    year: 24,
    context: "You went into a really big fight with your boy/girlfriend, do you choose to break up with him/her? ",
    status: 1,
    list: [{ label: 'Definitely!', power: { Happyness: -15}, index: 1 }, { label: 'No, we still love each other', power: { Happyness: 7 }, index: 1 }]
  },
  {
    year: 27,
    context: "Congrats! You are promoted based on your excellent performance! ",
    img: require('@/assets/promotion.jpg'),
    status: 0
  },
  {
    year: 29,
    context: "Your boss has offered you an oppotunity to work internationally, yet you family want you to stay",
    status: 1,
    list: [{ label: 'I am in charge me myself!', power: { Wealth: 15 }, index: 2}, { label: "It's time to take a step back and stay with the family", power: { Happyness: 12 }, index: 1 }]
  },
  {
    year: 32,
    context: "Your career is going smoothly and steadily, and you've balanced work and life very well. You continue to live a healthy and happy life with your family until you passed away",
    img: require('@/assets/GoodJob.jpg'),
    status: 2,
  },
  {
    year: 32,
    context: "You went into an accident on your flight. Time to restart again",
    img: require('@/assets/GoodJob.jpg'),
    status: 2,
  },
  
]

export {
  event
}