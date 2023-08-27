<template>
    <div style="font-size: 3vh">
      <div class="start_title" v-if="status == 0">
          <div class="title">{{ title }}</div>
          <div class="tip">{{ tip }}</div>
          <div style="margin-top: 16vh">
            <el-button @click="start">RESTART NOW!</el-button>
          </div>
      </div>
      <div v-if="status == 1">
        <div style="margin-top: 16vh">
          <div class="tip" style="letter-spacing: 0vh">Adjust Initial Attributes</div>
          <div class="small">Points Available: {{ count }}</div>
          <div>
            <div style="margin-top: 2vh">
              <strong>Health</strong><el-input-number v-model="userMsg.Health" :step="1" :min="0" :max="max1" style="margin-left: 3vh" />
            </div>
            <div style="margin-top: 2vh">
              Wealth<el-input-number v-model="userMsg.Happiness" :step="1" :min="0" :max="max2" style="margin-left: 3vh" />
            </div>
            <div style="margin-top: 2vh">
              Charm<el-input-number v-model="userMsg.IQ" :step="1" :min="0" :max="max3" style="margin-left: 3vh" />
            </div>
            <div style="margin-top: 2vh">
              IQ<el-input-number v-model="userMsg.IQ" :step="1" :min="0" :max="max4" style="margin-left: 3vh" />
            </div>
            <div style="margin-top: 2vh">
              Happiness<el-input-number v-model="userMsg.IQ" :step="1" :min="0" :max="max5" style="margin-left: 3vh" />
            </div>
          </div>
          <div style="margin-top: 4vh">
            <el-button type="warning" @click="random">Randomly Assign</el-button>
            <el-button type="success" @click="startLife">RESTART NOW</el-button>
          </div>
        </div>
      </div>
      <div v-if="status == 2" style="margin-top: 6vh;height: 100vh">
        <div>
          <el-table :data="data" style="width: 80%;margin: auto" border>
            <el-table-column prop="Health" label="Health" align="center" />
            <el-table-column prop="Wealth" label="Wealth" align="center" />
            <el-table-column prop="Charm" label="Charm" align="center" />
            <el-table-column prop="IQ" label="IQ" align="center" />
            <el-table-column prop="Happiness" label="Happiness" align="center" />
          </el-table>
        </div>
        <div class="life_content">
          <div class="card">
            <div v-if="myEvent.status == 0">
              <div style="margin-bottom: 5vh"><el-button @click="getEvent">Unlock New Event</el-button></div>
            </div>
            <div v-if="myEvent.status == 1">
              <div v-for="(item, index) in myEvent.list" :key="index" style="margin-bottom: 5vh">
                <el-button @click="getPower(item)">{{ item.label }}</el-button>
              </div>
            </div>
            <div v-if="myEvent.status == 2">
              <div style="margin-bottom: 5vh"><el-button @click="dialogVisible = true">Life Review</el-button></div>
              <div style="margin-bottom: 5vh"><el-button @click="reset">RESTART AGAIN</el-button></div>
            </div>
          </div>
          <div class="content">
            <div style="width=400, height=300">
              <img :src="myEvent.img"
                    width="400" />
            </div>
            <div style="height: 40%;font-size: 4vh;display: flex;align-items: center;justify-content: center">
              {{ myEvent.context }}
            </div>
          </div>
        </div>
      </div>
  
      <el-dialog title="Your Epitaph" :visible.sync="dialogVisible" width="30%" :show-close="false" :close-on-click-modal="false">
        <div>
          <p>Health: {{userMsg.Health}}</p >
          <p>Wealth: {{userMsg.Wealth}}</p >
          <p>Charm: {{userMsg.Charm}}</p >
          <p>IQ: {{userMsg.IQ}}</p >
          <p>Happiness: {{userMsg.Happiness}}</p >
          <p>You lived a wonderful life!</p >
        </div>
        <div style="margin-top: 2vh">
          <el-button type="warning" @click="dialogVisible = false">Life review</el-button>
          <el-button type="primary" @click="reset">RESTART AGAIN</el-button>
        </div>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import { event } from '@/js/event'
  export default {
    name: 'StartLife',
    data() {
      return {
        status: 0, // 0：准备开始阶段，1：准备加点阶段， 2：开启人生， 3：人生结束
        title: 'LIFE RESTARTER',
        tip: 'I have had enough of this F**king life!',
        userMsg: {
          Health: 0, // 健康
          Wealth: 0, // 财富
          Charm: 0, // 魅力
          IQ: 0, // 智商
          Happiness: 0 // 快乐
        },
        count: 20,
        index: 0,
        dialogVisible: false,
        myEvent: {}
      }
    },
    computed: {
      data() {
        return [this.userMsg]
      },
      max1() {
        return this.userMsg.Health + this.userMsg.Wealth + this.userMsg.Charm + this.userMsg.IQ + this.userMsg.Happiness === this.count ? this.userMsg.Health : this.count
      },
      max2() {
        return this.userMsg.Health + this.userMsg.Wealth + this.userMsg.Charm + this.userMsg.IQ + this.userMsg.Happiness === this.count ? this.userMsg.Wealth : this.count
      },
      max3() {
        return this.userMsg.Health + this.userMsg.Wealth + this.userMsg.Charm + this.userMsg.IQ + this.userMsg.Happiness === this.count ? this.userMsg.Charm : this.count
      },
      max4() {
        return this.userMsg.Health + this.userMsg.Wealth + this.userMsg.Charm + this.userMsg.IQ + this.userMsg.Happiness === this.count ? this.userMsg.IQ : this.count
      },
      max5() {
        return this.userMsg.Health + this.userMsg.Wealth + this.userMsg.Charm + this.userMsg.IQ + this.userMsg.Happiness === this.count ? this.userMsg.Happiness : this.count
      }
    },
    created() {
      console.log(event)
      this.myEvent = event[0]
    },
    methods: {
      start() { // 开始游戏
        this.status = 1
      },
      random() { // 随机分配属性值
        const result = [this.userMsg.Health, this.userMsg.Wealth, this.userMsg.Charm, this.userMsg.IQ, this.userMsg.Happiness]
        let remainingPoints = this.count - (this.userMsg.Health + this.userMsg.Wealth + this.userMsg.Charm + this.userMsg.IQ + this.userMsg.Happiness)
  
        while (remainingPoints > 0) {
          const randomIndex = Math.floor(Math.random() * 5)
          result[randomIndex]++
          remainingPoints--
        }
        [this.userMsg.Health, this.userMsg.Wealth, this.userMsg.Charm, this.userMsg.IQ, this.userMsg.Happiness] = result
      },
      startLife() { // 开始人生
        this.status = 2
        this.getEvent(false)
      },
      getEvent(val = true) { // 获取新事件, false为初始事件
        if (val) {
          this.index ++
        } else {
          this.myEvent = event[0]
        }
        let currentEvent = event[this.index];
  
        if (currentEvent.random) {
          const randomChance = Math.random();
  
          const randomIndex = Math.floor(randomChance * currentEvent.random.length);
  
          currentEvent = currentEvent.random[randomIndex];
        }
  
        this.myEvent = currentEvent;
      },
      getPower(item) { // 获得效果
        console.log(item.power)
        let { Health, Wealth, Charm, IQ, Happiness } = item.power
        this.userMsg.Health += Health || 0
        this.userMsg.Wealth += Wealth || 0
        this.userMsg.Charm += Charm || 0
        this.userMsg.IQ += IQ || 0
        this.userMsg.Happiness += Happiness || 0
        if (item.index) { // 如果有index则进行事件跳跃
          this.jumpEvent(item.index)
        } else {
          this.getEvent(true)
        }
      },
      jumpEvent(index) { // 获得效果
        this.index += index
        this.myEvent = event[this.index]
      },
      reset() {
        this.userMsg = {
          Health: 0, // 健康
          Wealth: 0, // 财富
          Charm: 0, // 魅力
          IQ: 0, // 智商
          Happiness: 0 // 快乐
        }
        this.count = 20
        this.status = 1
        this.index = 0
        this.dialogVisible = false
      }
    }
  }
  </script>
  
  <style scoped>
  .start_title {
    text-align: center;
  }
  .title {
    font-size: 10vh;
    letter-spacing: 2vh
  }
  .tip {
    font-size: 5vh;
    margin-top: 5vh;
  }
  .small {
    font-size: 2vh;
  }
  .life_content {
    display: flex;
    justify-content: space-around;
    margin-top: 8vh;
    height: 60%;
  }
  .card {
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    width: 30%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .content {
    width: 60%;
    height: 100%;
    text-align: center;
  }
  </style>