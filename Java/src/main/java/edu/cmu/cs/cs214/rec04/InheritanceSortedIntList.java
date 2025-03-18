package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        int addedCount = 0; // Track how many elements are actually added
        for (int i = 0; i < list.size(); i++) {
            if (super.add(list.get(i))) { // Only count elements that are successfully added
                addedCount++;
            }
        }
        totalAdded += addedCount; // Increment totalAdded only for new additions
        return addedCount > 0;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}