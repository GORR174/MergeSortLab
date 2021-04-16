package net.catstack.mergesortlab.utils

import com.sun.xml.internal.ws.util.xml.NodeListIterator
import org.w3c.dom.NamedNodeMap
import org.w3c.dom.Node
import org.w3c.dom.NodeList

fun NodeList.forEach(action: (Node) -> Unit) {
    NodeListIterator(this).forEach {
        val node = it as Node
        if (node.nodeType != Node.TEXT_NODE)
            action(it)
    }
}

operator fun NamedNodeMap.get(name: String): String? {
    return this.getNamedItem(name)?.textContent
}