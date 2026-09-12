import { ProcessState } from './ProcessState';

export interface ProcessInstance {
    processId?: string;
    processState?: ProcessState;
}
