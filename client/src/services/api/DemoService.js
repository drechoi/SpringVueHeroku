import Api from '@/services/api/Api';

export default {
  getTodo(params) {
    return Api().get('/todos/' + params.id);
  }
};
