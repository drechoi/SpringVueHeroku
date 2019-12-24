import { library } from '@fortawesome/fontawesome-svg-core';
import {
  faUserSecret,
  faStar as starSolid,
  faCalendarDay,
  faTrophy,
  faPiggyBank,
} from '@fortawesome/free-solid-svg-icons';

import {
  faStar as starRegular
} from '@fortawesome/free-regular-svg-icons';

const icons = [
  faUserSecret,
  starRegular,
  starSolid,
  faCalendarDay,
  faTrophy,
  faPiggyBank,
];

library.add(icons);
