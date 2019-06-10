import auth0 from 'auth0-js';
// import EventEmitter from 'events';
import authConfig from '../../../auth_config.json';
import Api from '@/services/api/Api';

const localStorageKey = 'loggedIn';

const webAuth = new auth0.WebAuth({
  domain: authConfig.domain,
  redirectUri: `${window.location.origin}/callback`,
  clientID: authConfig.clientId,
  responseType: 'id_token',
  scope: 'openid profile email'
});

export default {
  state: {
    test: '123',
    loggedIn: false,
    profile: {},
    idToken: null,
    tokenExpiry: null,
  },
  actions: {
    login() {
      webAuth.authorize({
        appState: { target: '/debug' }
      });
    },
    handleWebAuth() {
      return new Promise((resolve, reject) => {
        webAuth.parseHash((err, authResult) => {
          if (err) {
            console.log('handle web auth error: ');
            reject(err);
          } else {
            console.log('handle web auth');
            console.log(authResult);
            this.dispatch('localLogin', authResult);

            resolve(authResult);
          }
        });
      });
    },
    renewTokens() {
      return new Promise((resolve, reject) => {
        if (localStorage.getItem(localStorageKey) !== 'true') {
          return reject(new Error('Not logged in'));
        }

        webAuth.checkSession({}, (err, authResult) => {
          if (err) {
            reject(err);
          } else {
            this.dispatch('localLogin', authResult);
            resolve(authResult);
          }
        });
      });
    },
    logout: ({commit}) => {
      localStorage.setItem(localStorageKey, 'false');

      commit('logout');

      webAuth.logout({
        returnTo: window.location.origin
      });
    },
    localLogin: ({commit}, authResult) => {
      Api().post('user/login',
        {
          extId: '123',
          userName: 'test1234',
        })
        .then(response => {
          commit('login', authResult);
          localStorage.setItem(localStorageKey, 'true');
        })
        .catch((err) => {
          console.log(err);
          // failed commit logout
          // this.dispatch('logout');
          this.dispatch('logout');
        });
    },
  },
  mutations: {
    login(state, authResult) {
      state.idToken = authResult.idToken;
      state.profile = authResult.idTokenPayload;
      state.tokenExpiry = new Date(state.profile.exp * 1000);
      state.loggedIn = true;
    },
    logout(state) {
      state.idToken = null;
      state.tokenExpiry = null;
      state.profile = null;
      state.loggedIn = false;
    }
  },
  getters: {
  }
};
