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
            reject(err);
          } else {
            this.dispatch('localLogin', authResult)
              .then(() => {
                resolve(authResult);
              });
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
            this.dispatch('localLogin', authResult)
              .then(() => {
                resolve(authResult);
              });
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
    localLogin: ({commit, dispatch}, authResult) => {
      return new Promise((resolve, reject) => {
        let extProfile = authResult.idTokenPayload;
        Api()
          .post('user/login',
            {
              extId: extProfile.sub,
              userName: extProfile.name,
              picture: extProfile.picture,
            })
          .then(response => {
            const newState = {
              profile: response.data,
              idToken: authResult.idToken,
              tokenExpiry: new Date(authResult.idTokenPayload.exp * 1000),
            };
            console.log(newState);
            commit('login', newState);
            localStorage.setItem(localStorageKey, 'true');
            resolve();
          })
          .catch((err) => {
            console.log('login failed');
            console.log(err);
            // failed commit logout
            // this.dispatch('logout');
            dispatch('logout');
          });
      });
    },
  },
  mutations: {
    login(state, newState) {
      state.idToken = newState.idToken;
      state.profile = newState.profile;
      state.tokenExpiry = newState.tokenExpiry;
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
