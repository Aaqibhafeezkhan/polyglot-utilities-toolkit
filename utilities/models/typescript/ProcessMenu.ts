import { AbstractMenuItem } from './AbstractMenuItem';

export interface ProcessMenu {
    wsToken?: string;
    items?: Array<AbstractMenuItem>;
}
