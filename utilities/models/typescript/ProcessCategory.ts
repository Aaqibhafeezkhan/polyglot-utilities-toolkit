import { AbstractMenuItem } from './AbstractMenuItem';

export interface ProcessCategory extends AbstractMenuItem {
    icon?: string;
    items?: Array<AbstractMenuItem>;
}
