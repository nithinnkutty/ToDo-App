package uk.ac.cardiff.nithin;

class ToDoItem {
    private String itemDesc;
    private ItemStatus itemStatus;

    public ToDoItem(String itemDesc) {
        this.itemDesc = itemDesc;
        this.itemStatus = ItemStatus.OPEN;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public enum ItemStatus {
        OPEN,
        COMPLETED;
    }

}
