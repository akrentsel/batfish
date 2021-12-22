package org.batfish.vendor.a10.representation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.batfish.datamodel.SubRange;

/** An access-list rule matching udp traffic. */
public class AccessListRuleUdp implements AccessListRule {
  @Nonnull
  @Override
  public Action getAction() {
    return _action;
  }

  @Nonnull
  @Override
  public AccessListAddress getSource() {
    return _source;
  }

  @Nonnull
  @Override
  public AccessListAddress getDestination() {
    return _destination;
  }

  @Override
  public <T> T accept(AccessListRuleVisitor<T> visitor) {
    return visitor.visitUdp(this);
  }

  /** Destination port range this rule matches on. */
  @Nullable
  public SubRange getDestinationRange() {
    return _destinationRange;
  }

  @Nonnull
  @Override
  public String getLineText() {
    return _lineText;
  }

  public void setDestinationRange(@Nullable SubRange destinationRange) {
    _destinationRange = destinationRange;
  }

  public AccessListRuleUdp(
      Action action, AccessListAddress source, AccessListAddress destination, String lineText) {
    _action = action;
    _source = source;
    _destination = destination;
    _lineText = lineText;
  }

  @Nonnull private final Action _action;
  @Nonnull private final AccessListAddress _source;
  @Nonnull private final AccessListAddress _destination;
  @Nullable private SubRange _destinationRange;
  @Nonnull private final String _lineText;
}
