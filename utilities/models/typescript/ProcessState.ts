export interface ProcessState {
    state?: ProcessState.StateEnum;
}

export namespace ProcessState {
    export enum StateEnum {
        IDLE = 'IDLE',
        INPROGRESS = 'IN_PROGRESS',
        TERMINATED = 'TERMINATED'
    }
}
