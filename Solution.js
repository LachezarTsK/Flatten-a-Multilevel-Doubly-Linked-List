
/**
 * @param {Node} head
 * @return {Node}
 */
var flatten = function (head) {

    if (head === null) {
        return null;
    }

    const stack = [];
    if (head.next !== null) {
        stack.push(head.next);
    }
    if (head.child !== null) {
        stack.push(head.child);
        head.child = null;
    }

    let previous = head;
    while (stack.length > 0) {
        let current = stack.pop();

        if (current.next !== null) {
            stack.push(current.next);
        }
        if (current.child !== null) {
            stack.push(current.child);
            current.child = null;
        }

        previous.next = current;
        current.prev = previous;
        previous = previous.next;

    }
    return head;
};
