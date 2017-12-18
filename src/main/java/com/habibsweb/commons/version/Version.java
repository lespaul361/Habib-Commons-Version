/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibsweb.commons.version;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 *
 * @author David Hamilton
 */
public class Version implements Comparable<Version>, Serializable {

    private int major = 1;
    private int minor = 1;
    private int revision = 1;

    public Version() {
    }

    public Version(int major, int minor, int revision) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    /**
     * @return the major
     */
    public int getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(int major) {
        this.major = major;
    }

    /**
     * @return the minor
     */
    public int getMinor() {
        return minor;
    }

    /**
     * @param minor the minor to set
     */
    public void setMinor(int minor) {
        this.minor = minor;
    }

    /**
     * @return the revision
     */
    public int getRevision() {
        return revision;
    }

    /**
     * @param revision the revision to set
     */
    public void setRevision(int revision) {
        this.revision = revision;
    }

    @Override
    public String toString() {
        String ret = "{0}.{1}.{2}";
        ret = MessageFormat.format(ret, getMajor(), getMinor(), getRevision());
        return ret;
    }

    public static Version parseFromString(String s) {
        String[] parts = s.split("\\.");
        int maj = Integer.parseInt(parts[0].trim());
        int min = Integer.parseInt(parts[1].trim());
        int rev = Integer.parseInt(parts[2].trim());
        return new Version(maj, min, rev);
    }

    @Override
    public int compareTo(Version o) {
        if (getMajor() > o.getMajor()) {
            return 1;
        }
        if (getMajor() < o.getMajor()) {
            return -1;
        }
        if (getMinor() > o.getMinor()) {
            return 1;
        }
        if (getMinor() < o.getMinor()) {
            return -1;
        }
        if (getRevision() > o.getRevision()) {
            return 1;
        }
        if (getRevision() < o.getRevision()) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Version)) {
            return false;
        }
        if (compareTo((Version) o) == 0) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
