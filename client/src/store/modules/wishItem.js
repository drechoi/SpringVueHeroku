export default {
  state: {
    wishItems: [{
      id: 1,
      title: 'Wish Item A',
      project: 'Project A',
      description: 'Item A in store',
      status: 'New',
      // TODO: replaced with status
      done: false,
    },
    {
      id: 2,
      title: 'Wish Item B',
      project: 'Project B',
      description: 'I want item B',
      status: 'New',
      // TODO: replaced with status
      done: true,
    }]
  },
  actions: {
    test() {
    }
  },
  mutations: {
  },
  getters: {
  }
};
