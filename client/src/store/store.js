import Vue from 'vue';
import Vuex from 'vuex';
import wishModule from './modules/wishItem';
import AuthModule from './modules/Auth';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    someValue: 123
  },
  actions: {
  },
  mutations: {
    change(state, someValue) {
      state.someValue = someValue;
    },
    increment() {
      this.state.someValue++;
    }
  },
  getters: {
    someValueMinusTen: state => { return state.someValue - 10; }
  },
  modules: {
    wish: wishModule,
    auth: AuthModule,
  }
});
