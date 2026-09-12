import { AbstractMenuItem } from './AbstractMenuItem';

export interface ProcessItem extends AbstractMenuItem {
    processDefinitionId?: string;
}
