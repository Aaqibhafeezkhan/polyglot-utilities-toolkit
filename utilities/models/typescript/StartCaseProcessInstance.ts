import { ProcessInstance } from './ProcessInstance';

export interface StartCaseProcessInstance {
    wsToken?: string;
    processDefinitionId?: string;
    processState?: ProcessInstance;
}
