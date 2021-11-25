package com.jwd.E_Externalizable;

public class SerializableVsExternalizable {
    /*

    Customizing Serialization is using extra memory
        We can use transient keyword and JVM won't serialize such field but it will add this field to serialization with a default value.

    Responsibility
        Using java.io.Serializable JVM takes full responsibility for serializing.
        Using Externalizable we take care of both serialization and deserialization processes.

    Problem
        If serializing whole object - use Serializable.
        Externalizable is used for custom serialization - we control both serialization and deserialization.

    Read\write Externalizable field ordering
        Read all fields in the same order as they were written - or exception will be produced

    Performance
        Serializable uses reflection and metadata - slow tools.
        Externalizable gives you full control over serialization process - simple, means normal speed tooling.
     */
}
