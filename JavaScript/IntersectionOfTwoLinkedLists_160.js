/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */

/**
 Step 1: calculate the length of linkA and lengthB
 Step 2: Make the indexNode to the longer link move forward by diff nodes.
 Step 3: find the intersection node
 * @param headA
 * @param headB
 */
var getIntersectionNode = function(headA, headB) {
    if (headA == null || headB == null) return null;

    let lengthA = 0;
    let lengthB = 0;
    let indexA = headA;
    let indexB = headB;

    // Step 1: calculate the length of linkA and lengthB
    while (indexA != null) {
        lengthA++;
        indexA = indexA.next;
    }
    while (indexB != null) {
        lengthB++;
        indexB = indexB.next;
    }

    indexA = headA;
    indexB = headB;
    let diff;
    // Step 2: Make the indexNode to the longer link move forward by diff nodes.
    if (lengthA >= lengthB) {
        diff = lengthA - lengthB
        // make indexA moved forward by diff nodes
        for (let i = 0; i < diff; i++) {
            indexA = indexA.next;
        }
    } else {
        diff = lengthB - lengthA;
        // make indexB moved forward by diff nodes
        for (let i = 0; i < diff; i++) {
            indexB = indexB.next;
        }
    }

    // Step 3: find the intersection node
    while (indexA !== indexB) {
        indexA = indexA.next;
        indexB = indexB.next;
    }

    if (indexA == null || indexB == null) return null

    return indexA;
};