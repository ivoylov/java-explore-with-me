package ru.practicum.mainservice.event;

public enum EventStateAction {
    SEND_TO_REVIEW(Group.Initiator),
    PUBLISH_EVENT(Group.Admin),
    CANCEL_REVIEW(Group.Initiator),
    REJECT_EVENT(Group.Admin);

    private final Group group;

    EventStateAction(Group group) {
        this.group = group;
    }

    public boolean isInGroup(Group group) {
        return this.group == group;
    }

    public enum Group {
        Admin,
        Initiator
    }

}
