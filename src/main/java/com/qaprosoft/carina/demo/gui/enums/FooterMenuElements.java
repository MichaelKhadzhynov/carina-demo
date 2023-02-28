package com.qaprosoft.carina.demo.gui.enums;

public enum FooterMenuElements {
    HOME(0),
    NEWS(1),
    REVIEWS(2),
    COMPARE(3),
    COVERAGE(4),
    GLOSSARY(5),
    FAQ(6),
    RSS(7),
    YOU_TUBE(8),
    FACEBOOK(9),
    TWITTER(10),
    INSTAGRAM(11),
    GSM_ARENA_EDITORIAL_TEAM(12),
    MOBILE_VERSION(13),
    ANDROID_APP(14),
    TOOLS(15),
    CONTACT_US(16),
    MERCH_STORY(17),
    PRIVACY(18),
    TERMS_OF_USE(19);

    private final Integer footerElement;

    FooterMenuElements(Integer footerElement) {
        this.footerElement = footerElement;
    }

    public Integer getFooterElement() {
        return footerElement;
    }
}
