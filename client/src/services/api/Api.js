import axios from 'axios';

var tmp;
console.log(process.env);

if (process.env.LOCAL_MODE) {
  tmp = () => {};
} else {
  tmp = () => {
    return axios.create({
      baseURL: process.env.ROOT_API,
      withCredentials: false,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
  };
}

export default tmp;
